package com.group.moromoroapp.controller.product;

import com.group.moromoroapp.domain.product.Product;
import com.group.moromoroapp.dto.product.ProductCreateRequest;
import com.group.moromoroapp.dto.product.ProductResponse;
import com.group.moromoroapp.dto.product.ProductUpdateRequest;
import com.group.moromoroapp.service.product.ProductService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "http://192.168.0.7:8080/")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }



//    @GetMapping("/product")
//    public List<ProductResponse> getProduct(
//            @RequestParam(defaultValue = "0") int pageNo,
//            @RequestParam(defaultValue = "8") int pageSize,
//            @RequestParam(required = false) String condition
//    ) {
//        Pageable pageable = PageRequest.of(pageNo, pageSize);
//        Page<ProductResponse> productPage;
//
//        if (condition != null) {
//
//            productPage = productService.getProductsByCondition(condition, pageable);
//        } else {
//            productPage = productService.getProducts(pageable);
//        }
//
//        List<ProductResponse> productList = productPage.getContent();
//        return productList;
//    }
@GetMapping("/adminproduct")
public List<Product> adminProdGet(){
        return  productService.adminProdGet();
    }

@GetMapping("/product")
public List<ProductResponse> getProduct(
        @RequestParam(defaultValue = "0") int pageNo,
        @RequestParam(defaultValue = "8") int pageSize,
        @RequestParam(required = false) String condition
) {
    Sort sort = Sort.by(Sort.Direction.DESC, "productid"); // 등록일자를 기준으로 역순 정렬
    Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
    Page<ProductResponse> productPage;

    if (condition != null) {
        productPage = productService.getProductsByCondition(condition, pageable);
    } else {
        productPage = productService.getProducts(pageable);
    }

    List<ProductResponse> productList = productPage.getContent();
    return productList;
}

    @GetMapping("/productchoice")
    public Product productChoice(@RequestParam Long prId){
        return productService.productChoice(prId);
    }

    @GetMapping("/productlength")
    public long totalElements(@RequestParam String category) {
        long totalElements = productService.getProductsCount(category);
        return totalElements;
    }

    //이미지를 디렉토리에 저장 ... 이미지부터 저장하고 이후 디비 저장할거임
    @PostMapping("/productImg")
    public String productImg(@RequestParam("file")MultipartFile file){
        String uploadDir = "/var/www/html/img/prductimg/";
        String retDir = "/img/prductimg/";
//        String retDir = "/img/";

        String fileName = null;

        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        try {
             fileName = UUID.randomUUID().toString();

            File savedFile = new File(uploadDir + fileName+ "." + extension);
            file.transferTo(savedFile);
        } catch (IOException e) {
        }

//        System.out.println(uploadDir+fileName + "." + extension);
        return retDir+fileName + "." + extension;

    }

    // 디렉토리 저장 후 디비에 저장 할 거임 .
    @PostMapping("/Productsave")
    public void productSave(@RequestBody ProductCreateRequest request){
        productService.productSave(request);
    }


    @DeleteMapping("/product")
    public void productDel(@RequestParam Long prodId){
        productService.productDel(prodId);
    }

    //상품구매로

    @PutMapping("/productUpdate")
    public void productUpdate(@RequestBody ProductUpdateRequest request){
       productService.productUpdate(request);
    }

}