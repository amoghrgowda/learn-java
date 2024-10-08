package jade;
import org.lwjgl.Version;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.system.MemoryUtil;

public class Window {
int width,height;
String title;
private long glfwWindow;
private static Window window = null;


    private Window(){
        this.width=1920;
        this.height=1080;
        this.title="Mario";
    }

    public static Window get(){
        if(Window.window == null){
            Window.window = new Window();
        }
        return Window.window;
    }
    public void run(){
        System.out.println("Hello LWJGL "+ Version.getVersion()+"!");
        init();
        loop();
    }

    public void init(){
        //set up and error callback 
        GLFWErrorCallback.createPrint(System.err).set();

        //initialize GLFW
        if(!glfwInit()){
            throw new IllegalStateException("Unable to initialize GLFW");
        }

        //configure GLFW
        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
        glfwWindowHint(GLFW_MAXIMIZED, GLFW_TRUE);

        //Create window
        glfwWindow = glfwCreateWindow(this.width,this.height,this.title,MemoryUtil.NULL,MemoryUtil.NULL);
        if(glfwWindow == MemoryUtil.NULL ){
            throw new IllegalStateException("Failed to create GLFW window");
        }

        //Make the OpenGL context current
        glfwMakeContextCurrent(glfwWindow);
        //Enable v-sync
        glfwSwapInterval(1);

        //make the window visible
        glfwShowWindow(glfwWindow);

        GL.createCapabilities();
    }

    public void loop(){
        while(!glfwWindowShouldClose(glfwWindow)){
            //poll events
            glfwPollEvents();

            glClearColor(1.0f,0.0f,0.0f,1.0f);
            glClear(GL_COLOR_BUFFER_BIT);

            glfwSwapBuffers(glfwWindow);
        }
    }
}
