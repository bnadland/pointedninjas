package filter;

import ninja.Context;
import ninja.Filter;
import ninja.FilterChain;
import ninja.Result;
import ninja.Results;

public class AuthFilter implements Filter {

    @Override
    public Result filter(FilterChain chain, Context context) {
		return Results.json().render(context.getHeaders());
        //return chain.next(context);
	}
}
