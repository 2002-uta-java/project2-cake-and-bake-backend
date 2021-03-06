package com.revature.cake_and_bake.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.springframework.stereotype.Component;

@Component
@Embeddable
public class RecipeStepId implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
//	@PrimaryKeyJoinColumn(name = "rcp_id", referencedColumnName = "rcp_id")
	@JoinColumn(name = "rcp_id")
	private RecipeFull recipe;

	@Column(name = "rcp_step_no")
	private int stepNo;

	public RecipeStepId() {
		super();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecipeStepId other = (RecipeStepId) obj;
		if (recipe == null) {
			if (other.recipe != null)
				return false;
		} else if (!recipe.equals(other.recipe))
			return false;
		if (stepNo != other.stepNo)
			return false;
		return true;
	}

	public RecipeFull getRecipe() {
		return recipe;
	}

	public int getStepNo() {
		return stepNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((recipe == null) ? 0 : recipe.hashCode());
		result = prime * result + stepNo;
		return result;
	}

	public void setRecipe(RecipeFull recipe) {
		this.recipe = recipe;
	}

	public void setStepNo(int stepNo) {
		this.stepNo = stepNo;
	}

	@Override
	public String toString() {
		return "RecipeStepId [recipe=" + (recipe != null ? "" + recipe.getId() : "null") + ", stepNo=" + stepNo + "]";
	}

}
