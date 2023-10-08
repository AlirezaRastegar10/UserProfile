package com.alireza.java_code_challenge.service.province;


import com.alireza.java_code_challenge.dto.province.RegisterProvince;
import com.alireza.java_code_challenge.entity.County;
import com.alireza.java_code_challenge.entity.Province;
import com.alireza.java_code_challenge.mappers.ProvinceMapperImpl;
import com.alireza.java_code_challenge.repository.ProvinceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProvinceServiceImpl implements ProvinceService {

    private final ProvinceRepository provinceRepository;
    private final ProvinceMapperImpl provinceMapper;

    @Override
    public Province save(RegisterProvince registerProvince, County county) {
        var province = provinceMapper.provinceDtoToProvince(registerProvince);
        province.getCountyList().add(county);
        return provinceRepository.save(province);
    }
}
