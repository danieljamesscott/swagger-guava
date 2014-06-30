import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiImplicitParams;
import com.wordnik.swagger.annotations.ApiOperation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api(value = "/resource", description = "About the nessie application") @Path("/resource") @Produces(MediaType.APPLICATION_JSON)
public class Resource
{
    @ApiOperation(
            value = "About nessie",
            notes = "About nessie",
            response = Response.class) @GET @Timed
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "qparam", value = "Query Parameter", dataType = "string", required = true, paramType = "query")})

    public Response getAbout(@QueryParam("qparam") Optional<String> qparam)
    {
        return Response.ok().entity(qparam).build();
    }
}
