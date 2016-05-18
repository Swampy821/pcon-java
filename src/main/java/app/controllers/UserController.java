package app;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class UserController {

	// @RequestMapping( value="/rest/user/get", method=RequestMethod.GET )
	// public UserRequest get() {

	// }

	@RequestMapping( value="/rest/user/set/name", method=RequestMethod.GET )
	public SuccessResponse setName( 
		@RequestParam( value="name" ) String name,
		@RequestParam( value="username" ) String username ) {
		UserStore userStore = UserStore.getInstance();
		User user = userStore.getUserByUsername( username );
		if ( user != null ) {
			user.setName( name );
			return new SuccessResponse( true );
		} else {
			return new SuccessResponse( false );
		}
	}

	@RequestMapping( value="/rest/user/get", method=RequestMethod.GET )
	public GetUser get( 
		@RequestParam( value="username" ) String username,
		@RequestParam( value="token" ) String token ) {
		UserStore userStore = UserStore.getInstance();
		User authUser = userStore.authByToken( token );
		User user = userStore.getUserByUsername( username );
		if ( authUser != null ) {
			return new GetUser( user );
		} else {
			return new GetUser( null );
		}
	}

	@RequestMapping( value="/rest/user/add", method=RequestMethod.GET )
	public SuccessResponse add( @RequestParam( value="username" ) String username,
		@RequestParam( value="password" ) String password ) {
		UserStore userStore = UserStore.getInstance();
		return new SuccessResponse( 
			userStore.addUser( 
				new User( username, password )
			) 
		);
	}

	@RequestMapping( value="/rest/user/auth", method=RequestMethod.GET )
	public UserAuth auth( @RequestParam( value="username" ) String username,
		@RequestParam( value="password" ) String password ) {
		return new UserAuth( username, password );
	}
}