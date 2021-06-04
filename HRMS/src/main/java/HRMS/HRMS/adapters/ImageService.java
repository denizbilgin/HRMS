package HRMS.HRMS.adapters;

import org.springframework.web.multipart.MultipartFile;

import HRMS.HRMS.core.utilities.results.DataResult;

public interface ImageService
{
	DataResult<?> savePhoto(MultipartFile file);
}
