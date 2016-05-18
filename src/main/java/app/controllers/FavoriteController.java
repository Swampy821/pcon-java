package app;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class FavoriteController {

	@RequestMapping( value="/rest/favorite/get/list", method=RequestMethod.GET )
	public ArrayList getFavoriteList( 
		@RequestParam( value="token" ) String token ) {
		UserStore userStore = UserStore.getInstance();
		User user = userStore.getUserByAuthToken( token );
		if ( user != null ) {
			FavoriteStore favoriteStore = FavoriteStore.getInstance();
			return favoriteStore.getFavoritesById( user.getId() );
		} else {
			return null;
		}

	}
}