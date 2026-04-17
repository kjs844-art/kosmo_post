package com.joe.kosmo_post.pager;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Pager {
	
	//검색어
	private String search;
	//검색활용
	private String kind; //v1:title, v2:contents, v3:
	
	//페이지 번호
	private Long page;
	
	//페이지당 보여줄 글의 갯수 
	private Long perPage;
	
	//offset 번호 (시작 번호)
	private Long startNum;
	
	public Long getPage() {
		if(page==null||page<1) {
			this.page = 1L;
			}
		return this.page;
	}
	public Long getPerPage() {
		if(perPage == null || perPage<1) {
			this.perPage = 5L;
			}
		return this.perPage;
	}
		
	public void makeStartNum() {
		//1, 0;, 2, 5
		this.startNum = (this.getPage() - 1) * this.getPerPage();
	}
	public void setPage(long l) {
		// TODO Auto-generated method stub
		
	}
	public void setSearch(String string) {
		// TODO Auto-generated method stub
		
	}
		
	}
	//페이지 번호
	
	
	
	


