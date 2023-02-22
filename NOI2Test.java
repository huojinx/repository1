package pk2;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class NOI2Test {

	public NOI2Test() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) throws IOException{
		Path path = Paths.get(System.getProperty("user.dir"));
//		System.out.println(path.getFileName());
		try(DirectoryStream<Path> stream = 
				Files.newDirectoryStream(path,"*.{png,java}")){
			for(Path entry:stream) {
				showInf(entry);
			}
		}
	}
	
	static void showInf (Path path) throws IOException{
		System.out.println("文件名："+path.getFileName());
		System.out.println("是否是目录："+Files.isDirectory(path));
		System.out.println("文件大小："+Files.size(path)+"B");
		DosFileAttributes attr = Files.readAttributes(path, DosFileAttributes.class);
		System.out.println("创建时间："+attr.creationTime());
		System.out.println("是否只读："+attr.isReadOnly());
//		System.out.println(""+attr.isDirectory());
//		System.out.println(""+attr.size());
		System.out.println("最后修改时间："+attr.lastModifiedTime());
		System.out.println(".");
	}
}
