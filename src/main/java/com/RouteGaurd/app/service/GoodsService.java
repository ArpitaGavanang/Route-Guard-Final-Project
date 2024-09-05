package com.RouteGaurd.app.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RouteGaurd.app.exception.ResourceNotFoundException;
import com.RouteGaurd.app.model.Goods;
import com.RouteGaurd.app.repositories.GoodsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;

    public List<Goods> getAllGoods() {
        return goodsRepository.findAll();
    }

    public Optional<Goods> getGoodsById(Long id) {
        return goodsRepository.findById(id);
    }

    public Goods createGoods(Goods goods) {
        return goodsRepository.save(goods);
    }

    public Goods updateGoods(Long id, Goods updatedGoods) {
        return goodsRepository.findById(id)
            .map(goods -> {
                goods.setDescription(updatedGoods.getDescription());
                goods.setWeight(updatedGoods.getWeight());
                goods.setVolume(updatedGoods.getVolume());
                goods.setValue(updatedGoods.getValue());
                goods.setCategory(updatedGoods.getCategory());
                goods.setModifiedBy(updatedGoods.getModifiedBy());
                goods.setModifiedAt(updatedGoods.getModifiedAt());
                return goodsRepository.save(goods);
            })
            .orElseThrow(() -> new ResourceNotFoundException("Goods not found with id " + id));
    }

    public void deleteGoods(Long id) {
        goodsRepository.deleteById(id);
    }
}

