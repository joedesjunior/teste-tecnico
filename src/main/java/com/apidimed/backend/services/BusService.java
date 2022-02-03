package com.apidimed.backend.services;

import com.apidimed.backend.dtos.BusDTO;
import com.apidimed.backend.models.BusModel;
import com.apidimed.backend.repositories.BusRepository;
import com.apidimed.backend.services.request.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusService {

    @Autowired
    private BusRepository busRepository;

    // Método responsável por listar todos os ônibus
    public List<BusModel> listAll() {
        return busRepository.findAll();
    }

    // Método responsável por buscar no http cliente os ônibus
    public Boolean importBusHttp() {
        try {
            HttpRequest cliente = new HttpRequest();
            List<BusDTO> linhas = cliente.buscaLinhasTransporte();
            for (BusDTO linhaDTO : linhas) {
                Optional<BusModel> optional = busRepository.findById(Long.parseLong(linhaDTO.getId()));
                BusModel linha = new BusModel();
                if ("".equals(optional)) {
                    linha.setId(Long.parseLong(linhaDTO.getId()));
                } else {
                    linha.setId(Long.parseLong(linhaDTO.getId()));
                }
                linha.setCodigo(linhaDTO.getCodigo());
                linha.setNome(linhaDTO.getNome());
                busRepository.save(linha);
            }
            cliente.close();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
