package acme.features.chef.recipes;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.recipe.Recipe;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.entities.AbstractEntity;
import acme.framework.services.AbstractShowService;
import acme.roles.Chef;

@Service
public class ChefRecipeShowService implements AbstractShowService<Chef, Recipe> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected ChefRecipeRepository repository;

	// AbstractShowService<Chef, Recipe> interface --------------------------

	@Override
	public boolean authorise(final Request<Recipe> request) {
		assert request != null;
		
		Integer id = request.getModel().getInteger("id");
		Optional<AbstractEntity> result =  this.repository.findById(id);

		return result.isPresent();
	}

	@Override
	public void unbind(final Request<Recipe> request, final Recipe entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "heading", "code", "description", "preparationNotes", "link");
	}

	@Override
	public Recipe findOne(final Request<Recipe> request) {
		assert request != null;
		
		Recipe result;
		int id;

		id = request.getModel().getInteger("id");
		result = (Recipe) this.repository.findById(id).get();

		assert result != null;
		
		return result;
	}
}
