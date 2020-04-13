package com.icici.ivault.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.icici.ivault.DTO.DenominationDTO;



public interface DenominationService {
	DenominationDTO addDenomination(DenominationDTO denominationDTO);

	List<DenominationDTO> getDenominationList();
	}
