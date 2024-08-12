package scala_maven;

public class AppLauncher extends Launcher {
    public AppLauncher(String id, String mainClass, String[] jvmArgs, String[] args) {
        this.id = id;
        this.mainClass = mainClass;
        this.jvmArgs = jvmArgs;
        this.args = args;
    }

    public String getId() {
        return id;
    }

    public String getMainClass() {
        return mainClass;
    }

    public String[] getJvmArgs() {
        String[] args = {
            "--add-opens",
            "java.base/java.io=ALL-UNNAMED",
            "--add-opens",
            "java.base/java.lang=ALL-UNNAMED",
            "--add-opens",
            "java.base/java.lang.reflect=ALL-UNNAMED",
            "--add-opens",
            "java.base/java.net=ALL-UNNAMED",
            "--add-opens=java.base/java.nio=ALL-UNNAMED",
            "--add-opens",
            "java.base/sun.nio.ch=ALL-UNNAMED",
            "--add-opens=java.base/sun.nio.ch=ALL-UNNAMED",
            "--add-opens",
            "java.base/java.nio.file=ALL-UNNAMED",
            "--add-opens",
            "java.base/java.time=ALL-UNNAMED",
            "--add-opens",
            "java.base/java.util=ALL-UNNAMED",
            "--add-opens",
            "java.base/sun.util.calendar=ALL-UNNAMED",
            "--add-opens",
            "java.base/java.util.concurrent=ALL-UNNAMED",
            "--add-exports=java.base/sun.nio.ch=ALL-UNNAMED",
            "--add-exports",
            "java.base/sun.nio.ch=ALL-UNNAMED",
            "--add-exports",
            "java.base/sun.security.jca=ALL-UNNAMED",
            "--add-exports",
            "java.base/sun.security.util=ALL-UNNAMED",
            "--add-exports",
            "java.base/sun.util.calendar=ALL-UNNAMED",
        };

        String[] resArray = new String[args.length + jvmArgs.length];
        
        System.arraycopy(args, 0, resArray, 0, args.length);
        System.arraycopy(jvmArgs, 0, resArray, args.length, jvmArgs.length);
        return resArray;
    }

    public String[] getArgs() {
        return args;
    }
}
