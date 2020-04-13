package com.icici.ivault.repository;

import java.util.List;

import com.icici.ivault.model.Denomination;

public interface DenominationRepository {

	Denomination addNewDeno(Denomination denomination);

	List<Denomination> getDenominationList();
}
