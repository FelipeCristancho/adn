package com.ceiba.adn.domain.service.generalRules;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

@Service
public class MostRepeatedElement {

	public long getMostRepeatedElement(List<Long> identifications) {
		HashMap<Long, Integer> map = new HashMap<>();
		for (int i = 0; i < identifications.size(); i++) {
			long number = identifications.get(i);
			if (map.containsKey(number)) {
				map.put(number, map.get(number) + 1);
			} else {
				map.put(number, 1);
			}
		}
		long mostRepeated = 0;
		int mayor = 0;
		for (Entry<Long, Integer> entry : map.entrySet()) {
			if (entry.getValue() > mayor) {
				mayor = entry.getValue();
				mostRepeated = entry.getKey();
			}
		}
		return mostRepeated;
	}
}
