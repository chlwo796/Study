package javaMid8.ex07;

// Ȯ�ι��� 9.7

public class Chatting {
	class Chat {
		void start() {

		}

		void sendMessage(String message) {

		}
	}

	void startChat(String chatId) {
		String nickName;
		nickName = chatId;

		Chat chat = new Chat() {
			@Override
			void start() {
				while (true) {
					String inputData = "�ȳ��ϼ���";
					String message = "[" + nickName + "] " + inputData;
					sendMessage(message);
				}
			}
		};

		chat.start();
	}
}