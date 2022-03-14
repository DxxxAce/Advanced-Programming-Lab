package lab3;

public class Main {

	public static void main(String[] args) {
		
		Node v1 = new Computer("v1", "127.0.0.1", 32);
        Node v2 = new Router("v2", "127.0.0.2", "00:00:5e:00:53:af");
        Node v3 = new Switch("v3", "A");
        Node v4 = new Switch("v4", "B");
        Node v5 = new Router("v5", "634.34.43.5", "00:00:3e:00:21:sd");
        Node v6 = new Computer("v6", "634.34.43.3", 84);
        
        v1.setCost(v2, 10);
        v1.setCost(v3, 50);
        v2.setCost(v3, 20);
        v2.setCost(v4, 20);
        v2.setCost(v5, 20);
        v3.setCost(v4, 10);
        v4.setCost(v5, 30);
        v4.setCost(v6, 10);
        v5.setCost(v6, 20);
        
        Network network= new Network();
        network.addNode(v1);
        network.addNode(v2);
        network.addNode(v3);
        network.addNode(v4);
        network.addNode(v5);
        network.addNode(v6);

        System.out.println(network);
	}

}
