package acme.features.any.partOf;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.partOf.PartOf;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.entities.AbstractEntity;
import acme.framework.roles.Any;
import acme.framework.services.AbstractShowService;

@Service
public class AnyPartOfShowService implements AbstractShowService<Any, PartOf> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AnyPartOfRepository repository;

	// AbstractShowService<Anonymous, PartOf> interface --------------------------

	@Override
	public boolean authorise(final Request<PartOf> request) {
		assert request != null;
		
		Integer id = request.getModel().getInteger("id");
		Optional<AbstractEntity> result =  this.repository.findById(id);

		return result.isPresent();
	}

	@Override
	public void unbind(final Request<PartOf> request, final PartOf entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "quantity", "unit","recipe.heading", "artifact.name");
	}

	@Override
	public PartOf findOne(final Request<PartOf> request) {
		assert request != null;
		
		PartOf result;
		int id;

		id = request.getModel().getInteger("id");
		result = (PartOf) this.repository.findById(id).get();

		assert result != null;
		
		return result;
	}
}
