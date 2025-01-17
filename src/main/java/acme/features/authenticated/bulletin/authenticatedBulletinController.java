package acme.features.authenticated.bulletin;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.bulletin.Bulletin;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Authenticated;

@Controller
public class authenticatedBulletinController extends AbstractController<Authenticated, Bulletin> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected authenticatedBulletinListService	listService;

	@Autowired
	protected authenticatedBulletinShowService	showService;

	// Constructors -----------------------------------------------------------


	@PostConstruct
	protected void initialise() {
		super.addCommand("list", this.listService);
		super.addCommand("show", this.showService);
	}

}
