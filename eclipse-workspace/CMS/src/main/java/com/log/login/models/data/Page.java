package com.log.login.models.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.persistence.Id;
@Entity
@Table(name="pages")
public class Page {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
		
		private int id;
		
		@Size(min=2, message="Title must be atleast 2 characters long")
		private String title;
		private String slug;
		@Size(min=5, message="Title must be atleast 5 characters long")
		private String content;
		private int sorting;
		public int getSorting() {
			return sorting;
		}
		public void setSorting(int sorting) {
			this.sorting = sorting;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getSlug() {
			return slug;
		}
		public void setSlug(String slug) {
			this.slug = slug;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		

}
