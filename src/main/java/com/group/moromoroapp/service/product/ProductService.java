//package com.group.libraryapp.service.product;
//
//import com.group.libraryapp.domain.product.ProductRepository;
//import com.group.libraryapp.dto.product.ProductResponse;
//
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.awt.print.Pageable;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class ProductService {
//    private final ProductRepository productRepository;
//
//    public ProductService(ProductRepository productRepository){this.productRepository = productRepository;}
//
//
//    @Transactional(readOnly = true)
////    public List<ProductResponse> getProduct() {
////        return productRepository.findAll().stream()
////                .map(ProductResponse::new)
////                .collect(Collectors.toList());
////    }
//    public Page<ProductResponse> getProducts(Pageable pageable) {
//        return productRepository.findAll(pageable).map(ProductResponse::new);
//    }
//}
package com.group.moromoroapp.service.product;

import com.group.moromoroapp.domain.product.Product;
import com.group.moromoroapp.domain.product.ProductRepository;
import com.group.moromoroapp.dto.product.ProductCreateRequest;
import com.group.moromoroapp.dto.product.ProductResponse;

import com.group.moromoroapp.dto.product.ProductUpdateRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    public List<Product> adminProdGet(){
        return productRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Page<ProductResponse> getProducts(Pageable pageable) {
        return productRepository.findAll(pageable).map(ProductResponse::new);
    }

    @Transactional(readOnly = true)
    public Page<ProductResponse> getProductsByCondition(String condition ,Pageable pageable) {
        return productRepository.findByCategory(condition, pageable).map(ProductResponse::new);
    }

    @Transactional(readOnly = true)
    public Product productChoice(Long prId){
        return productRepository.findByProductid(prId);
    }

    @Transactional(readOnly = true)
    public long getProductsCount(String category) {

        if (category.equals("all")){
            return productRepository.count();
        }
        return productRepository.countByCategory(category);
    }

    @Transactional
    public void productSave(ProductCreateRequest request){
        Product product = new Product(request.getPr_name(),request.getMainimage(),request.getServeimage(),request.getPrice(),request.getStock(),request.getCategory(),request.getExplanation(),request.getStar(),request.getTotalsales());

        productRepository.save(product);

    }
    @Transactional
    public void productDel(Long prodId){
        Product product = productRepository.findByProductid(prodId);

        productRepository.delete(product);
        List<String> imgs = new ArrayList<>();
        if(product.getMainimage()!= null){
            imgs.add(product.getMainimage());
        }
        if (product.getServeimage() != null){
            imgs.add(product.getServeimage());
        }

        for (int i = 0; i < imgs.size(); i++) {
            String filePath = imgs.get(i);
            //서버 올렸을때 ... 서버의 디렉토리경로로 변경하면 아래 작업 안함.
//            String[] test = filePath.split("http://localhost:8083/v1/static/imgs/");
//            System.out.println(test[1]);
///var/www/html/img/prductimg/
//            File file = new File("/Users/hanul_kim/Desktop/학원/프로젝트/library-app (2)id추가/src/main/resources/static/v1/static/imgs/"+ test[1]);
            File file = new File("/var/www/html/"+filePath);
            file.delete();
        }
    }

    public void productUpdate(ProductUpdateRequest request){
        Product product = productRepository.findByProductid(request.getProductid());

        product.updateProd(request.getPr_name(),request.getMainimage(),request.getServeimage(),request.getPrice(),request.getStock(),request.getCategory(),request.getExplanation(),request.getStar(),request.getTotalsales());

        productRepository.save(product);
    }


}