package com.suns.poolscoket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class SunsClient1 {
    public static void main(String[] args) {
        Socket socket = null;
        PrintWriter printWriter = null;
        try {
            socket = new Socket("127.0.0.1", 8080);
            printWriter = new PrintWriter(socket.getOutputStream());
            printWriter.write("send date to server ");
            printWriter.flush();

        } catch (Exception e) {
            //<editor-fold desc="异常处理">
            e.printStackTrace();
            //</editor-fold>
        } finally {
            //<editor-fold desc="关闭Socket资源">
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (printWriter != null) {
                printWriter.close();
            }
            //</editor-fold>
        }
    }
}
