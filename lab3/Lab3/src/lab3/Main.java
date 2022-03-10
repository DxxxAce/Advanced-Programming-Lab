package lab3;

public class Main {

	public static void main(String[] args) {
		
		Node v1 = new Computer("v1", "127.0.0.1", "8234", "A" , 32);
        Node v2 = new Router("v2", "127.0.0.2", "8234", "A");
        Node v3 = new Switch("v3", "127.0.0.3", "8234", "A");
        Node v4 = new Switch("v4", "127.0.0.4", "6345", "B");
        Node v5 = new Router("v5", "634.34.43.5", "6345", "B");
        Node v6 = new Computer("v6", "634.34.43.3", "6345", " B", 84);
        
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
