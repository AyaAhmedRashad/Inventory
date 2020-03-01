package com.inventory.task.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.task.dto.PackagingDTO;
import com.inventory.task.dto.productTypeDTO;
import com.inventory.task.entities.Packaging;
import com.inventory.task.entities.ProductType;
import com.inventory.task.enums.PackageType;
import com.inventory.task.repos.PackagingRepo;
import com.inventory.task.services.PackageService;

@Service
public class PackageServiceImpl implements PackageService {
	// this class service contain all operations related to Packaging entity class
	@Autowired
	PackagingRepo packageRepo;
	
	//this service for creating new package in database restricted to the package types Enum
	@Transactional
	@Override
	public boolean addNewPackage(PackagingDTO packageDto) throws Exception {
		if(packageDto.getId()!=null) {
			throw new Exception("can not insert id , it is automatic generated");
		}
		if(packageDto.getPackageName()==null||packageDto.getPackageQuantity()==null||packageDto.getPackageType()==null) {
			throw new Exception("package name, quantity and type all can not be null ");
		}
		if(PackageType.getEnum(packageDto.getPackageType())==null) {
			throw new Exception("package type should be from the identified types ");
		}
		else {
		try {
			Packaging packageEntity=new Packaging(packageDto.getPackageName(),packageDto.getPackageQuantity(),PackageType.getEnum(packageDto.getPackageType()).getNumVal());
			packageRepo.save(packageEntity);
			return true;
		}
		catch(Exception ex) {
			throw ex;
		}
		}
	}
	
	//this service for updating existing package like quantity or name..
	@Transactional
	@Override
	public boolean updatePackage(PackagingDTO packageDto) throws Exception {
		if(packageDto.getId()==null) {
			throw new Exception("id of package should be added");
		}
		if(packageDto.getPackageName()==null&&packageDto.getPackageQuantity()==null&&packageDto.getPackageType()==null) {
			throw new Exception("all package name ,quantity and type can not be null ");
		}
		if(!packageRepo.existsById(packageDto.getId())) {
			throw new Exception("this package id is not exist");
		}
		if(packageDto.getPackageType()!=null) {
		 if(PackageType.getEnum(packageDto.getPackageType())==null) {
			throw new Exception("package type should be from the identified types ");
		 }
		}
			
			try {
				Packaging packaging=packageRepo.findById(packageDto.getId()).get();
				if(packageDto.getPackageName()!=null) {
					packaging.setPackageName(packageDto.getPackageName());
				}
				if(packageDto.getPackageQuantity()!=null) {
					packaging.setPackageQuantity(packageDto.getPackageQuantity());
				}
				if(packageDto.getPackageType()!=null) {
					packaging.setPackageType(PackageType.getEnum(packageDto.getPackageType()).getNumVal());
				}
				packageRepo.save(packaging);
				return true;
			}
		
			catch(Exception ex) {
				throw ex;
			}
	
	}
	
	//this service for deleting specific package from the database
	@Transactional
	@Override
	public boolean deletePackage(int id) throws Exception {
		 if(!packageRepo.existsById(id)) {
	    	 throw new Exception("this package id is not exist");
	     }
	     else {
	    	 try {
	    		 packageRepo.deleteById(id);
	    		 return true;
	    	 }
	    	 catch(Exception ex) {
	    		 throw ex;
	    	 }
	    
	     }
	}
	
	//this service to get one Package details from the database by package id and mapping it to DTO in return
	@Transactional
	@Override	
    public PackagingDTO findById(int id) throws Exception {
		 if(!packageRepo.existsById(id)) {
	    	 throw new Exception("this package id is not exist");
	     }
	     else {
	    	 try {
	    		 Packaging packaging= packageRepo.findById(id).get();
	    		 PackagingDTO dto=new PackagingDTO (packaging.getId(),packaging.getPackageName(),packaging.getPackageQuantity(),packaging.getPackageType());
	    		 return dto;
	    	 }
	    	 catch(Exception ex) {
	    		 throw ex;
	    	 }
	    
	     }
	}
	
	//this service to get All packages from the database and mapping them to DTO in return
	@Transactional
	@Override
    public List<PackagingDTO> findAll() throws Exception {
		
		try {
			List<Packaging>packagingList=packageRepo.findAll();
			List<PackagingDTO> packagingListDTO=new ArrayList<PackagingDTO>();
			for(Packaging packagingEntity:packagingList) {
				PackagingDTO packagingDTO=new PackagingDTO(packagingEntity.getId(),packagingEntity.getPackageName(),packagingEntity.getPackageQuantity(),packagingEntity.getPackageType());
				packagingListDTO.add(packagingDTO);
			}
			return packagingListDTO;
			}
			catch(Exception ex) {
				throw ex;
			}
	}
	
	//this service is also to get one package from the database by package id and return it as entity to be used in another services
			//without mapping to DTO
	@Transactional
	@Override
	
     public Packaging findByPackageID(int id) throws Exception {
		 if(!packageRepo.existsById(id)) {
	    	 throw new Exception("this package id is not exist");
	     }
	     else {
	    	 try {
	    		 return packageRepo.findById(id).get();
	    	 }
	    	 catch(Exception ex) {
	    		 throw ex;
	    	 }
	    
	     }
	}

}
