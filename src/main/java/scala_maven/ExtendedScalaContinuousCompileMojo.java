package scala_maven;

import org.apache.maven.project.MavenProject;
import org.apache.maven.toolchain.Toolchain;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import util.FileUtils;

// This is a java file instead of Scala because method implementations are copy pasted
public class ExtendedScalaContinuousCompileMojo extends ScalaContinuousCompileMojo {
    public MavenProject getProject() {
        return super.project;
    }

    public List<String> getScalacArgs() throws Exception {
        List<String> args = super.getScalacOptions();
        // args.add("--add-opens");
        // args.add("java.base/java.io=ALL-UNNAMED");
        // args.add("--add-opens");
        // args.add("java.base/java.lang=ALL-UNNAMED");
        // args.add("--add-opens");
        // args.add("java.base/java.lang.reflect=ALL-UNNAMED");
        // args.add("--add-opens");
        // args.add("java.base/java.net=ALL-UNNAMED");
        // args.add("--add-opens=java.base/java.nio=ALL-UNNAMED");
        // args.add("--add-opens");
        // args.add("java.base/sun.nio.ch=ALL-UNNAMED");
        // args.add("--add-opens=java.base/sun.nio.ch=ALL-UNNAMED");
        // args.add("--add-opens");
        // args.add("java.base/java.nio.file=ALL-UNNAMED");
        // args.add("--add-opens");
        // args.add("java.base/java.time=ALL-UNNAMED");
        // args.add("--add-opens");
        // args.add("java.base/java.util=ALL-UNNAMED");
        // args.add("--add-opens");
        // args.add("java.base/sun.util.calendar=ALL-UNNAMED");
        // args.add("--add-opens");
        // args.add("java.base/java.util.concurrent=ALL-UNNAMED");
        // args.add("--add-exports=java.base/sun.nio.ch=ALL-UNNAMED");
        // args.add("--add-exports");
        // args.add("java.base/sun.nio.ch=ALL-UNNAMED");
        // args.add("--add-exports");
        // args.add("java.base/sun.security.jca=ALL-UNNAMED");
        // args.add("--add-exports");
        // args.add("java.base/sun.security.util=ALL-UNNAMED");
        // args.add("--add-exports");
        // args.add("java.base/sun.util.calendar=ALL-UNNAMED");
        return args;
    }

    public List<File> getCompileSourceDirectories() throws Exception {
        List<String> mainSources = new ArrayList<String>(project.getCompileSourceRoots());
        mainSources.add(FileUtils.pathOf(mainSourceDir, useCanonicalPath));
        return normalize(mainSources);
    }

    public List<File> getTestSourceDirectories() throws Exception {
        List<String> testSources = new ArrayList<String>(project.getTestCompileSourceRoots());
        testSources.add(FileUtils.pathOf(testSourceDir, useCanonicalPath));
        return normalize(testSources);
    }

    public File getCompileOutputDir() throws Exception {
        mainOutputDir = FileUtils.fileOf(mainOutputDir, useCanonicalPath);
        if (!mainOutputDir.exists()) {
            mainOutputDir.mkdirs();
        }
        return mainOutputDir;
    }

    public File getTestOutputDir() throws Exception {
        testOutputDir = FileUtils.fileOf(testOutputDir, useCanonicalPath);
        if (!testOutputDir.exists()) {
            testOutputDir.mkdirs();
        }
        return testOutputDir;
    }

    public Boolean getFork() {
        return super.fork;
    }

    public File getCompileAnalysisCacheFile() throws Exception {
        return FileUtils.fileOf(analysisCacheFile, useCanonicalPath);
    }

    public File getTestAnalysisCacheFile() throws Exception {
        return FileUtils.fileOf(testAnalysisCacheFile, useCanonicalPath);
    }

    public File getJavaHome() throws Exception {
        String _javaExec = null;
        Toolchain toolchain = getToolchain();
        if (toolchain != null)
            _javaExec = toolchain.findTool("java");

        if (toolchain == null || _javaExec == null) {
            _javaExec = System.getProperty("java.home");
            if (_javaExec == null) {
                _javaExec = System.getenv("JAVA_HOME");
                if (_javaExec == null) {
                    throw new IllegalStateException("Couldn't locate java, try setting JAVA_HOME environment variable.");
                }
            }
            _javaExec += File.separator + "bin" + File.separator + "java";
        }

        return new File(_javaExec);
    }
}
