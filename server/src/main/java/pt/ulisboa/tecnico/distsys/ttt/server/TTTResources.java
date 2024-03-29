package pt.ulisboa.tecnico.distsys.ttt.server;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pt.ulisboa.tecnico.distsys.ttt.contract.PlayRequest;
import pt.ulisboa.tecnico.distsys.ttt.contract.PlayResult;

/**
 * Root resource (exposed at "game" path)
 */
@Path("game")
public class TTTResources {
	
	/**
	 * 
	 * TTTGame currently being played
	 * 
	 */
	static TTTGame game = new TTTGame();

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return Board that will be returned as a text/plain response.
     */ 
    @GET
    @Path("board")
    @Produces(MediaType.TEXT_PLAIN)
    public String getBoard() {
    	return game.toString();
    }
    
    
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return Board that will be returned as a text/plain response.
     */ 
    @GET
    @Path("board/reset")
    @Produces(MediaType.TEXT_PLAIN)
    public String resetBoard() {
        game.resetBoard();
        return game.toString();
    }
    
    
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return Integer representing the winner that will be returned as a text/plain response.
     */ 
    @GET
    @Path("board/checkwinner")
    @Produces(MediaType.TEXT_PLAIN)
    public int checkWinner() {
        return game.checkWinner();
    }
    
    
    /**
     * Method handling HTTP POST requests. The returned object will be sent
     * to the client as "json" media type.
     * 
     * @param PlayRequest as a XML param
     * @return PlayResult object that will be returned as a json response.
     */ 
    @POST
    @Path("play")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PlayResult play(PlayRequest request) {
    	return this.checkPlay(request.getRow(), request.getColumn(), request.getPlayer());
    }
    

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "json" media type.
     * 
     * @param row as int
     * @param column as int
     * @param player id as int
     * @return PlayResult object that will be returned as a json response.
     */ 
    @GET
    @Path("play/{row}/{col}/{pid}")
    @Produces(MediaType.APPLICATION_JSON)
    public PlayResult play(@PathParam("row") int row, @PathParam("col") int col, @PathParam("pid") int pid) {
    	return this.checkPlay(row, col, pid);
    }
    
    private PlayResult checkPlay(int row, int col, int pid) {
		/*
		 * If you want to reset when you perform a request to the server with the play, uncomment this line. (it helps support the browser playing)
		 * if(game.checkWinner() != -1) game.resetBoard();
		 */
    	return game.play(row, col, pid);
    }
}
