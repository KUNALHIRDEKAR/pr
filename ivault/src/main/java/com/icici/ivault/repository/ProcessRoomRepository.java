package com.icici.ivault.repository;

import java.util.List;

import com.icici.ivault.model.Denomination;

public interface ProcessRoomRepository {

	List<Denomination> getAllDenomination();
}
