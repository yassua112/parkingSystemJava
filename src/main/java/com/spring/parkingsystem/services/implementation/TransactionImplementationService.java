package com.spring.parkingsystem.services.implementation;

import com.spring.parkingsystem.dtos.arsip.ArsipHeaderDto;
import com.spring.parkingsystem.dtos.transaction.MasukParkirDto;
import com.spring.parkingsystem.dtos.transaction.TransactionFilterDto;
import com.spring.parkingsystem.dtos.transaction.TransactionHeaderDto;
import com.spring.parkingsystem.models.Arsip;
import com.spring.parkingsystem.models.Category;
import com.spring.parkingsystem.models.Transaction;
import com.spring.parkingsystem.repositories.ArsipRepository;
import com.spring.parkingsystem.repositories.CategoryRepository;
import com.spring.parkingsystem.repositories.TransactionRepository;
import com.spring.parkingsystem.services.abstraction.CrudService;
import com.spring.parkingsystem.services.abstraction.TransactionService;
import com.spring.parkingsystem.utility.MapperHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service("transactionMenu")
public class TransactionImplementationService implements TransactionService, CrudService {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private ArsipRepository arsipRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    private final int rowsInPage = 10;

    @Override
    public Page<Object> getHeader(Integer page, Object filter, Class<?> filterType) {
        Pageable pagination = PageRequest.of(page - 1, rowsInPage, Sort.by("id"));
        String keterangan = MapperHelper.getStringField(filter, "keterangan", TransactionFilterDto.class);
        Page<Object> header = transactionRepository.findAll(keterangan, pagination);
        return header;
    }

    @Override
    public TransactionHeaderDto masukParkirMotor(MasukParkirDto motor) {
        Transaction masukMotor = motor.parkirMotor(new Transaction());
        transactionRepository.save(masukMotor);
        return TransactionHeaderDto.set(masukMotor);
    }

    @Override
    public TransactionHeaderDto masukParkirMobil(MasukParkirDto mobil) {
        Category category = categoryRepository.getById("Mobil");
        Transaction masukMobil = mobil.parkirMobil(new Transaction(), category);
        transactionRepository.save(masukMobil);
        return TransactionHeaderDto.set(masukMobil);
    }

    @Override
    public TransactionHeaderDto masukParkirMoge(MasukParkirDto moge) {
        Transaction masukMoge = moge.parkirMoge(new Transaction());
        transactionRepository.save(masukMoge);
        return TransactionHeaderDto.set(masukMoge);
    }

    @Override
    public ArsipHeaderDto keluarParkir(ArsipHeaderDto arsip, Integer id) {
        Transaction transaction = transactionRepository.findById(id).get();
        Arsip keluar = arsip.keluarParkir(new Arsip(), transaction);
        arsipRepository.save(keluar);
        return ArsipHeaderDto.set(keluar);
    }


    @Override
    public Object getUpdate(Object id) {
        return null;
    }

    @Override
    public Object save(Object dto, Class<?> dtoType) {
        return null;
    }

    @Override
    public Boolean delete(Object id) {
        return null;
    }
}
