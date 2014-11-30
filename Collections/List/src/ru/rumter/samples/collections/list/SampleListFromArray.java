package ru.rumter.samples.collections.list;

import java.util.*;

/**
 * Пример создания списка из массива постоянной длины.
 * <p/>
 * Полученный список не поддерживает вставку новых значений (выбрасывает UnsupportedOperationException).
 */
public class SampleListFromArray {
	
	public static void main(String args[]) {
//		List<Integer> list = Arrays.asList(1, 2, 3);	// создаем список из массива постоянной длины
		List<Integer> list = new ArrayList(Arrays.asList(1, 2, 3)); // рабочий вариант

		try {
			list.add(4);	// пробуем добавить элемент
		}
		catch(Exception e) {
			e.printStackTrace();	// получаем UnsupportedOperationException
		}
		
		System.out.println("list.size = " + list.size());
	}

}