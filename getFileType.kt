enum class FileCategory {
    IMAGE, VIDEO, AUDIO, DOCUMENT, ARCHIVE, EXECUTABLE, CODE, FONT, DATABASE, MODEL, DISK_IMAGE, CONFIG, FILE
}

data class FileTypeResult(val mimeType: String, val category: FileCategory)

val mimeTypeMap = mapOf(
    "avif" to "image/avif",
    "jpeg" to "image/jpeg",
    "jpg" to "image/jpeg",
    "png" to "image/png",
    "bmp" to "image/bmp",
    "gif" to "image/gif",
    "svg" to "image/svg+xml",
    "webp" to "image/webp",
    "ico" to "image/vnd.microsoft.icon",
    "tif" to "image/tiff",
    "tiff" to "image/tiff",
    "psd" to "image/vnd.adobe.photoshop",
    "ai" to "application/postscript",
    "sketch" to "application/sketch",
    "mp4" to "video/mp4",
    "webm" to "video/webm",
    "ogv" to "video/ogg",
    "avi" to "video/x-msvideo",
    "mpeg" to "video/mpeg",
    "3gp" to "video/3gpp",
    "3g2" to "video/3gpp2",
    "mp3" to "audio/mpeg",
    "wav" to "audio/wav",
    "weba" to "audio/webm",
    "oga" to "audio/ogg",
    "opus" to "audio/opus",
    "midi" to "audio/midi",
    "aac" to "audio/aac",
    "pdf" to "application/pdf",
    "doc" to "application/msword",
    "docx" to "application/vnd.openxmlformats-officedocument.wordprocessingml.document",
    "xls" to "application/vnd.ms-excel",
    "xlsx" to "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
    "ppt" to "application/vnd.ms-powerpoint",
    "pptx" to "application/vnd.openxmlformats-officedocument.presentationml.presentation",
    "txt" to "text/plain",
    "csv" to "text/csv",
    "rtf" to "application/rtf",
    "odt" to "application/vnd.oasis.opendocument.text",
    "zip" to "application/zip",
    "rar" to "application/vnd.rar",
    "7z" to "application/x-7z-compressed",
    "tar" to "application/x-tar",
    "gz" to "application/gzip",
    "bz2" to "application/x-bzip2",
    "exe" to "application/x-msdownload",
    "sh" to "application/x-sh",
    "bat" to "application/x-msdos-program",
    "apk" to "application/vnd.android.package-archive",
    "ipa" to "application/octet-stream",
    "jar" to "application/java-archive",
    "app" to "application/x-macos-app",
    "deb" to "application/x-deb",
    "rpm" to "application/x-rpm",
    "js" to "text/javascript",
    "ts" to "text/typescript",
    "py" to "text/x-python",
    "java" to "text/x-java-source",
    "cpp" to "text/x-c",
    "c" to "text/x-c",
    "kt" to "text/x-kotlin",
    "rs" to "text/x-rust",
    "swift" to "text/x-swift",
    "go" to "text/x-go",
    "php" to "text/x-php",
    "rb" to "text/x-ruby",
    "sqlite" to "application/x-sqlite3",
    "db" to "application/x-database",
    "sql" to "application/sql",
    "stl" to "model/stl",
    "obj" to "model/obj",
    "fbx" to "model/fbx",
    "blend" to "model/blender",
    "iso" to "application/x-iso9660-image",
    "img" to "application/octet-stream",
    "ini" to "text/plain",
    "log" to "text/plain",
    "cfg" to "text/plain",
    "ttf" to "font/ttf",
    "woff" to "font/woff",
    "woff2" to "font/woff2",
    "otf" to "font/otf"
)

val categoryMap = mapOf(
    "image/" to FileCategory.IMAGE,
    "video/" to FileCategory.VIDEO,
    "audio/" to FileCategory.AUDIO,
    "application/pdf" to FileCategory.DOCUMENT,
    "application/msword" to FileCategory.DOCUMENT,
    "application/vnd.openxmlformats-officedocument" to FileCategory.DOCUMENT,
    "application/vnd.ms-powerpoint" to FileCategory.DOCUMENT,
    "application/vnd.oasis.opendocument" to FileCategory.DOCUMENT,
    "application/vnd.ms-excel" to FileCategory.DOCUMENT,
    "text/plain" to FileCategory.DOCUMENT,
    "text/csv" to FileCategory.DOCUMENT,
    "application/rtf" to FileCategory.DOCUMENT,
    "application/zip" to FileCategory.ARCHIVE,
    "application/vnd.rar" to FileCategory.ARCHIVE,
    "application/x-7z-compressed" to FileCategory.ARCHIVE,
    "application/x-tar" to FileCategory.ARCHIVE,
    "application/gzip" to FileCategory.ARCHIVE,
    "application/x-bzip2" to FileCategory.ARCHIVE,
    "application/x-msdownload" to FileCategory.EXECUTABLE,
    "application/vnd.android.package-archive" to FileCategory.EXECUTABLE,
    "application/octet-stream" to FileCategory.EXECUTABLE,
    "application/java-archive" to FileCategory.EXECUTABLE,
    "application/x-deb" to FileCategory.EXECUTABLE,
    "application/x-rpm" to FileCategory.EXECUTABLE,
    "text/javascript" to FileCategory.CODE,
    "text/typescript" to FileCategory.CODE,
    "text/x-python" to FileCategory.CODE,
    "text/x-java-source" to FileCategory.CODE,
    "text/x-c" to FileCategory.CODE,
    "text/x-kotlin" to FileCategory.CODE,
    "text/x-rust" to FileCategory.CODE,
    "text/x-swift" to FileCategory.CODE,
    "text/x-go" to FileCategory.CODE,
    "text/x-php" to FileCategory.CODE,
    "text/x-ruby" to FileCategory.CODE,
    "application/x-sqlite3" to FileCategory.DATABASE,
    "application/x-database" to FileCategory.DATABASE,
    "application/sql" to FileCategory.DATABASE,
    "model/" to FileCategory.MODEL,
    "application/x-iso9660-image" to FileCategory.DISK_IMAGE,
    "text/plain" to FileCategory.CONFIG,
    "font/" to FileCategory.FONT
)

fun getFileType(url: String): FileTypeResult {
    val extensionMatch = Regex("\\.([0-9a-z]+)(?:[?#]|$)").find(url)
    if (extensionMatch == null) return FileTypeResult("unknown", FileCategory.FILE.toString())

    val extension = extensionMatch.groupValues[1].lowercase()
    val mimeType = mimeTypeMap[extension] ?: "application/octet-stream"

    val category = categoryMap[mimeType]
        ?: categoryMap.entries.find { mimeType.startsWith(it.key) }?.value
        ?: FileCategory.FILE

    return FileTypeResult(mimeType, category.toString())
}
