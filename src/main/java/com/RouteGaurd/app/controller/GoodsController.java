package com.RouteGaurd.app.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.RouteGaurd.app.model.Goods;
import com.RouteGaurd.app.service.GoodsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/get-goods")
    public List<Goods> getAllGoods() {
        return goodsService.getAllGoods();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Goods> getGoodsById(@PathVariable Long id) {
        Optional<Goods> goods = goodsService.getGoodsById(id);
        return goods.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add-goods")
    public Goods createGoods(@RequestBody Goods goods) {
        return goodsService.createGoods(goods);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Goods> updateGoods(@PathVariable Long id, @RequestBody Goods updatedGoods) {
        return ResponseEntity.ok(goodsService.updateGoods(id, updatedGoods));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGoods(@PathVariable Long id) {
        goodsService.deleteGoods(id);
        return ResponseEntity.noContent().build();
    }
}
