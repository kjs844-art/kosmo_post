package com.joe.kosmo_post.pager;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Pager {

	private String search = "";
	private String kind;
	private Long page;
	private Long perPage;
	private Long startNum;
	private boolean pre = true;
	private boolean next = true;
	private Long start;
	private Long end;

	public Long getPage() {
		if (page == null || page < 1) {
			this.page = 1L;
		}
		return this.page;
	}

	public Long getPerPage() {
		if (perPage == null || perPage < 1) {
			this.perPage = 5L;
		}
		return this.perPage;
	}

	public void makePageNum(Long totalCount) {
		Long totalPage = (long) (Math.ceil((double) totalCount / this.getPerPage()));

		Long perBlock = 5L;
		Long totalBlock = totalPage / perBlock;
		if (totalPage % 5 != 0) {
			totalBlock++;
		}

		Long curBlock = this.getPage() / perBlock;
		if (this.page % perBlock != 0) {
			curBlock++;
		}

		start = (curBlock - 1) * perBlock + 1;
		end = curBlock * perBlock;

		if (curBlock == totalBlock) {
			end = totalPage;
			next = false;
		}

		if (curBlock < 2) {
			pre = false;
		}
	}

	public void makeStartNum() {
		this.startNum = (this.getPage() - 1) * this.getPerPage();
	}
}
