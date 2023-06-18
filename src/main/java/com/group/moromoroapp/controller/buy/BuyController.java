package com.group.moromoroapp.controller.buy;


import com.group.moromoroapp.domain.buy.Buyhistory;
import com.group.moromoroapp.dto.buy.BuyCreateRequest;
import com.group.moromoroapp.service.buy.BuyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "http://192.168.0.7:8080/")
public class BuyController {

    private final BuyService buyService;

    public BuyController(BuyService buyService){
        this.buyService = buyService;
    }

    @PostMapping("/buy")
    public void saveBuy(@RequestBody BuyCreateRequest request){
        buyService.saveBuy(request);
    }

    @GetMapping("/buy")
    public List<Buyhistory> getBuy(@RequestParam Long userId){
       return buyService.getBuy(userId);
    }

}
