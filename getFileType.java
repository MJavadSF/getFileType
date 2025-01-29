import java.util.HashMap;
import java.util.Map;

public class FileTypeChecker {
    public enum FileCategory {
        IMAGE, VIDEO, AUDIO, DOCUMENT, ARCHIVE, EXECUTABLE, CODE, FONT, DATABASE, MODEL, DISK_IMAGE, CONFIG, FILE
    }

    public static class FileTypeResult {
        String mimeType;
        FileCategory category;

        public FileTypeResult(String mimeType, FileCategory category) {
            this.mimeType = mimeType;
            this.category = category;
        }
    }

    private static final Map<String, String> mimeTypeMap = new HashMap<>() {{
        put("avif", "image/avif");
        put("jpeg", "image/jpeg");
        put("jpg", "image/jpeg");
        put("png", "image/png");
        put("bmp", "image/bmp");
        put("gif", "image/gif");
        put("svg", "image/svg+xml");
        put("webp", "image/webp");
        put("ico", "image/vnd.microsoft.icon");
        put("tif", "image/tiff");
        put("tiff", "image/tiff");
        put("psd", "image/vnd.adobe.photoshop");
        put("ai", "application/postscript");
        put("sketch", "application/sketch");
        put("mp4", "video/mp4");
        put("webm", "video/webm");
        put("ogv", "video/ogg");
        put("avi", "video/x-msvideo");
        put("mpeg", "video/mpeg");
        put("3gp", "video/3gpp");
        put("3g2", "video/3gpp2");
        put("mp3", "audio/mpeg");
        put("wav", "audio/wav");
        put("weba", "audio/webm");
        put("oga", "audio/ogg");
        put("opus", "audio/opus");
        put("midi", "audio/midi");
        put("aac", "audio/aac");
        put("pdf", "application/pdf");
        put("doc", "application/msword");
        put("docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        put("xls", "application/vnd.ms-excel");
        put("xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        put("ppt", "application/vnd.ms-powerpoint");
        put("pptx", "application/vnd.openxmlformats-officedocument.presentationml.presentation");
        put("txt", "text/plain");
        put("csv", "text/csv");
        put("rtf", "application/rtf");
        put("odt", "application/vnd.oasis.opendocument.text");
        put("zip", "application/zip");
        put("rar", "application/vnd.rar");
        put("7z", "application/x-7z-compressed");
        put("tar", "application/x-tar");
        put("gz", "application/gzip");
        put("bz2", "application/x-bzip2");
        put("exe", "application/x-msdownload");
        put("sh", "application/x-sh");
        put("bat", "application/x-msdos-program");
        put("apk", "application/vnd.android.package-archive");
        put("ipa", "application/octet-stream");
        put("jar", "application/java-archive");
        put("app", "application/x-macos-app");
        put("deb", "application/x-deb");
        put("rpm", "application/x-rpm");
        put("js", "text/javascript");
        put("ts", "text/typescript");
        put("py", "text/x-python");
        put("java", "text/x-java-source");
        put("cpp", "text/x-c");
        put("c", "text/x-c");
        put("kt", "text/x-kotlin");
        put("rs", "text/x-rust");
        put("swift", "text/x-swift");
        put("go", "text/x-go");
        put("php", "text/x-php");
        put("rb", "text/x-ruby");
        put("sqlite", "application/x-sqlite3");
        put("db", "application/x-database");
        put("sql", "application/sql");
        put("stl", "model/stl");
        put("obj", "model/obj");
        put("fbx", "model/fbx");
        put("blend", "model/blender");
        put("iso", "application/x-iso9660-image");
        put("img", "application/octet-stream");
        put("ini", "text/plain");
        put("log", "text/plain");
        put("cfg", "text/plain");
        put("ttf", "font/ttf");
        put("woff", "font/woff");
        put("woff2", "font/woff2");
        put("otf", "font/otf");
    }};

    private static final Map<String, FileCategory> categoryMap = new HashMap<>() {{
        put("image/", FileCategory.IMAGE);
        put("video/", FileCategory.VIDEO);
        put("audio/", FileCategory.AUDIO);
        put("application/pdf", FileCategory.DOCUMENT);
        put("application/msword", FileCategory.DOCUMENT);
        put("application/vnd.openxmlformats-officedocument", FileCategory.DOCUMENT);
        put("application/vnd.ms-powerpoint", FileCategory.DOCUMENT);
        put("application/vnd.oasis.opendocument", FileCategory.DOCUMENT);
        put("application/vnd.ms-excel", FileCategory.DOCUMENT);
        put("text/plain", FileCategory.DOCUMENT);
        put("text/csv", FileCategory.DOCUMENT);
        put("application/rtf", FileCategory.DOCUMENT);
        put("application/zip", FileCategory.ARCHIVE);
        put("application/vnd.rar", FileCategory.ARCHIVE);
        put("application/x-7z-compressed", FileCategory.ARCHIVE);
        put("application/x-tar", FileCategory.ARCHIVE);
        put("application/gzip", FileCategory.ARCHIVE);
        put("application/x-bzip2", FileCategory.ARCHIVE);
        put("application/x-msdownload", FileCategory.EXECUTABLE);
        put("application/vnd.android.package-archive", FileCategory.EXECUTABLE);
        put("application/octet-stream", FileCategory.EXECUTABLE);
        put("application/java-archive", FileCategory.EXECUTABLE);
        put("application/x-deb", FileCategory.EXECUTABLE);
        put("application/x-rpm", FileCategory.EXECUTABLE);
        put("text/javascript", FileCategory.CODE);
        put("text/typescript", FileCategory.CODE);
        put("text/x-python", FileCategory.CODE);
        put("text/x-java-source", FileCategory.CODE);
        put("text/x-c", FileCategory.CODE);
        put("text/x-kotlin", FileCategory.CODE);
        put("text/x-rust", FileCategory.CODE);
        put("text/x-swift", FileCategory.CODE);
        put("text/x-go", FileCategory.CODE);
        put("text/x-php", FileCategory.CODE);
        put("text/x-ruby", FileCategory.CODE);
        put("application/x-sqlite3", FileCategory.DATABASE);
        put("application/x-database", FileCategory.DATABASE);
        put("application/sql", FileCategory.DATABASE);
        put("model/", FileCategory.MODEL);
        put("application/x-iso9660-image", FileCategory.DISK_IMAGE);
        put("text/plain", FileCategory.CONFIG);
        put("font/", FileCategory.FONT);
    }};

    public static FileTypeResult getFileType(String url) {
        String extension = url.replaceAll(".*\\.([0-9a-z]+).*", "$1").toLowerCase();
        String mimeType = mimeTypeMap.getOrDefault(extension, "application/octet-stream");

        FileCategory category = categoryMap.get(mimeType);
        if (category == null) {
            category = categoryMap.entrySet().stream()
                    .filter(entry -> mimeType.startsWith(entry.getKey()))
                    .map(Map.Entry::getValue)
                    .findFirst()
                    .orElse(FileCategory.FILE);
        }

        return new FileTypeResult(mimeType, category);
    }

    public static void main(String[] args) {
        System.out.println(getFileType("example.jpg").mimeType);
    }
}
