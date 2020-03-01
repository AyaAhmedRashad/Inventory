package com.inventory.task.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.inventory.task.entities.Packaging;
import com.inventory.task.entities.ProductInventory;
import com.inventory.task.entities.ProductType;
@Repository
public interface ProductInventoryRepo  extends JpaRepository<ProductInventory, Integer> ,JpaSpecificationExecutor<ProductInventory> {
	//this service used to get all products details according to productType and is ordered
 public List<ProductInventory> findByProductTypeIdAndIsOrdered(ProductType productTypeId,boolean isOrdered);
//this service used to get all products details according to productType and is ordered and package Id
 public List<ProductInventory> findByProductTypeIdAndPackageIdAndIsOrdered(ProductType productTypeId,Packaging packageId,boolean isOrdered);
}
