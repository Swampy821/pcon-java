package app;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class TodoController {

	@RequestMapping( value="/rest/todo/get", method=RequestMethod.GET )
	public Todo todo() {
		return new Todo();
	}

	@RequestMapping( value="/rest/todo/add", method=RequestMethod.POST )
	public Todo todo( @RequestParam( value="content" ) String content ) {
		Todo T = new Todo();
		T.addItem( content );
		return T;
	}

	@RequestMapping( value="/rest/todo/remove", method=RequestMethod.POST )
	public Todo todo( @RequestParam( value="index" ) int index ) {
		Todo T = new Todo();
		T.removeItem( index );
		return T;
	}
}