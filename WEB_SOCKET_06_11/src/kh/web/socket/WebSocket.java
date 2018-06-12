package kh.web.socket;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

//pojo - Plaind Old Java Object  :simple bean

@ServerEndpoint("/websocket")
public class WebSocket  {
	public static Set<Session> clients = Collections.synchronizedSet(new HashSet<>());
	List<String> listTalk = new ArrayList<>();
	private static int connetorCount =1;
	@OnOpen
	public void handleOpen(Session session) {
		//클라이언트가 접속했을때  실행   오버라이딩에 극한되는것을 극복 
		System.out.println(connetorCount++ + "사용자가 접속했습니다");
		clients.add(session);
		
	}
	@OnMessage
	public void handleMessage(String message) throws Exception{
		//클라이언트가 메세지가 도착했을때 
		//listTalk.add(message);


			for(Session tmp : clients) {
				tmp.getBasicRemote().sendText(message);
			}

//		for(Session tmp : clients) {
//			tmp.getBasicRemote().sendText(message);
//			//클라이언트에 보내기 
//		}

	}
	
	@OnClose
	public void handleClose(Session session) {
		//클라이언트가 닫혔을때 
		clients.remove(session);
	}
	// 예외 처리 들   Throwable 
	public void handleError(Throwable t) {
		t.getMessage();
	}
	
}
