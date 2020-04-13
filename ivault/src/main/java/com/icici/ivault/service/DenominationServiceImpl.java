package com.icici.ivault.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.icici.ivault.DTO.DenominationDTO;
import com.icici.ivault.model.Denomination;
import com.icici.ivault.repository.DenominationRepository;
/**
 * 
 * @author Kunal Hirdekar
 *
 */
@Service
public class DenominationServiceImpl implements DenominationService {

	@Autowired
	private DenominationRepository denominationRepository;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public DenominationDTO addDenomination(DenominationDTO denominationDTO) {
		Denomination denomination=new Denomination();
		BeanUtils.copyProperties(denominationDTO,denomination);
		Denomination denomination2=new Denomination();
		System.out.println("Inside Service class"+denominationDTO);
		
		if(denomination.getImdDenomination()>=100) {
			denomination.setImdPrFlag(1);
		denomination2=denominationRepository.addNewDeno(denomination);
		}
		else 
		{
			denomination2=denominationRepository.addNewDeno(denomination);
			
		}
		
		
		DenominationDTO denominationDTO2=new DenominationDTO();
		BeanUtils.copyProperties(denomination2,denominationDTO2);
		return denominationDTO2;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<DenominationDTO> getDenominationList() {
		
		List<Denomination> denominationList= denominationRepository.getDenominationList();
		List<DenominationDTO> denominationDTOList=new ArrayList();
		for(Denomination denomination:denominationList)
		{
			DenominationDTO d=new DenominationDTO();
			BeanUtils.copyProperties(denomination, d);
			denominationDTOList.add(d);
		}
		return denominationDTOList;
	}

}
