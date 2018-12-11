package com.cskaoyan.domain.customize;

import java.util.List;

public class EUDataGridResult {

	//引用的总数
	private long total;
	//引用的行数
	private List<?> rows;
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	
}
