package HRMS.HRMS.adapters;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;

import HRMS.HRMS.core.utilities.results.DataResult;
import HRMS.HRMS.core.utilities.results.ErrorDataResult;
import HRMS.HRMS.core.utilities.results.SuccessDataResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryImageAdapter implements ImageService
{
	private Cloudinary cloudinary;

	@Autowired
	public CloudinaryImageAdapter(Cloudinary cloudinary)
	{
		this.cloudinary = cloudinary;
	}

	@Override
	public DataResult<Map> savePhoto(MultipartFile file)
	{
		try
		{
			Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
			return new SuccessDataResult<Map>(uploadResult);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return new ErrorDataResult<Map>();
	}
}
