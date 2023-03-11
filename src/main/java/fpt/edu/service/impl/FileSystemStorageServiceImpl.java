package fpt.edu.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.commons.io.FilenameUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import fpt.edu.config.StorageProperties;
import fpt.edu.exception.StorageException;
import fpt.edu.exception.StorageFileNotFoundException;
import fpt.edu.service.StorageService;

@Service
public class FileSystemStorageServiceImpl implements StorageService {
	private final Path rootLocation;

	@Override
	public String getStoragedFilename(MultipartFile file, String id) {
		String ext = FilenameUtils.getExtension(file.getOriginalFilename());
		return "p" + id + "." + ext;

	}

	public FileSystemStorageServiceImpl(StorageProperties properties) {
		this.rootLocation = Paths.get(properties.getLocation());

	}

	@Override
	public void store(MultipartFile file, String storedFilename) {
		try {
			if(file.isEmpty()) {
				throw new StorageException("Failed to store empty file");
			}
			
			Path destinationFile = this.rootLocation.resolve(Paths.get(storedFilename))
					.normalize().toAbsolutePath();
			//chuẩn hóa tuyệt đối
			
			if(!destinationFile.getParent().equals(this.rootLocation.toAbsolutePath())) {
				throw new StorageException("Cannot store file outside current directory");
			}
			
			try(InputStream inputStream = file.getInputStream()){
				Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
			}
		} catch (Exception e) {
			throw new StorageException("Failed to store file", e);
		}
	}	
		// nạp tài nguyên vào các file
		@Override
		public Resource  loadAsResource(String filename) {
			try {
				Path file = load(filename);
				Resource resource = new UrlResource(file.toUri());
				if(resource.exists() || resource.isReadable()) {
					return resource;
				}
				
				throw new StorageFileNotFoundException("Could not read file: " + filename);
			} catch (Exception e) {
				throw new StorageFileNotFoundException("Could not read file: " + filename);
			}
		}

		@Override
		public Path load(String filename) {
			return rootLocation.resolve(filename);
		}
		// phương thức xóa file khi không cần thiết
		@Override
		public void delete(String storedFilename) throws IOException {
			Path destinationFile = rootLocation.resolve(Paths.get(storedFilename).normalize().toAbsolutePath());
			Files.delete(destinationFile);
		}
		
		//phương thức dùng để khởi tạo
		@Override
		public void init() {
			try {
				Files.createDirectories(rootLocation);
				System.out.println(rootLocation.toString());
			} catch (Exception e) {
				throw new StorageException("Could not intialize storage", e);
			}
		}
}
