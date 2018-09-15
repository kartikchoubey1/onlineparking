package com.onlineparking.util;

import java.util.ArrayList;
import java.util.List;

public class CommonUtil {
	public static List<Integer> cvsIds(String ids) {
		System.out.println("ids----" + ids);
		List<Integer> integers = new ArrayList<Integer>();
		String[] cvsIds = ids.split(",");
		if (cvsIds != null) {
			for (String val : cvsIds) {
				integers.add(Integer.parseInt(val));
			}
		}
		return integers;

	}
}
