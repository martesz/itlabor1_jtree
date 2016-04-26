import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
import java.util.Arrays;

public class FileWrap {
	File value;

	public File getValue() {
		return value;
	}

	public void setValue(File value) {
		this.value = value;
	}

	public FileWrap(File file) {
		value = file;
	}

	@Override
	public String toString() {
		return value.getName();
	}

	public boolean canExecute() {
		return value.canExecute();
	}

	public boolean canRead() {
		return value.canRead();
	}

	public boolean canWrite() {
		return value.canWrite();
	}

	public int compareTo(File pathname) {
		return value.compareTo(pathname);
	}

	public boolean createNewFile() throws IOException {
		return value.createNewFile();
	}

	public boolean delete() {
		return value.delete();
	}

	public void deleteOnExit() {
		value.deleteOnExit();
	}

	public boolean equals(Object obj) {
		return value.equals(obj);
	}

	public boolean exists() {
		return value.exists();
	}

	public File getAbsoluteFile() {
		return value.getAbsoluteFile();
	}

	public String getAbsolutePath() {
		return value.getAbsolutePath();
	}

	public File getCanonicalFile() throws IOException {
		return value.getCanonicalFile();
	}

	public String getCanonicalPath() throws IOException {
		return value.getCanonicalPath();
	}

	public long getFreeSpace() {
		return value.getFreeSpace();
	}

	public String getName() {
		return value.getName();
	}

	public String getParent() {
		return value.getParent();
	}

	public File getParentFile() {
		return value.getParentFile();
	}

	public String getPath() {
		return value.getPath();
	}

	public long getTotalSpace() {
		return value.getTotalSpace();
	}

	public long getUsableSpace() {
		return value.getUsableSpace();
	}

	public int hashCode() {
		return value.hashCode();
	}

	public boolean isAbsolute() {
		return value.isAbsolute();
	}

	public boolean isDirectory() {
		return value.isDirectory();
	}

	public boolean isFile() {
		return value.isFile();
	}

	public boolean isHidden() {
		return value.isHidden();
	}

	public long lastModified() {
		return value.lastModified();
	}

	public long length() {
		return value.length();
	}

	public String[] list() {
		String[] result = value.list();
	    Arrays.sort(result);
		return result;
	}

	public String[] list(FilenameFilter filter) {
		return value.list(filter);
	}

	public File[] listFiles() {
		File[] result = value.listFiles();
	    Arrays.sort(result);
		return result;
		
	}

	public File[] listFiles(FileFilter filter) {
		return value.listFiles(filter);
	}

	public File[] listFiles(FilenameFilter filter) {
		return value.listFiles(filter);
	}

	public boolean mkdir() {
		return value.mkdir();
	}

	public boolean mkdirs() {
		return value.mkdirs();
	}

	public boolean renameTo(File dest) {
		return value.renameTo(dest);
	}

	public boolean setExecutable(boolean executable, boolean ownerOnly) {
		return value.setExecutable(executable, ownerOnly);
	}

	public boolean setExecutable(boolean executable) {
		return value.setExecutable(executable);
	}

	public boolean setLastModified(long time) {
		return value.setLastModified(time);
	}

	public boolean setReadOnly() {
		return value.setReadOnly();
	}

	public boolean setReadable(boolean readable, boolean ownerOnly) {
		return value.setReadable(readable, ownerOnly);
	}

	public boolean setReadable(boolean readable) {
		return value.setReadable(readable);
	}

	public boolean setWritable(boolean writable, boolean ownerOnly) {
		return value.setWritable(writable, ownerOnly);
	}

	public boolean setWritable(boolean writable) {
		return value.setWritable(writable);
	}

	public Path toPath() {
		return value.toPath();
	}

	public URI toURI() {
		return value.toURI();
	}

	public URL toURL() throws MalformedURLException {
		return value.toURL();
	}
}
