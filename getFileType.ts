type FileCategory =
  | 'image'
  | 'video'
  | 'audio'
  | 'document'
  | 'archive'
  | 'executable'
  | 'code'
  | 'font'
  | 'database'
  | '3d-model'
  | 'disk-image'
  | 'config'
  | 'file';

interface FileTypeResult {
  mimeType: string;
  category: FileCategory;
}

const mimeTypeMap: Record<string, string> = {
  // image
  avif: 'image/avif',
  jpeg: 'image/jpeg',
  jpg: 'image/jpeg',
  png: 'image/png',
  bmp: 'image/bmp',
  gif: 'image/gif',
  svg: 'image/svg+xml',
  webp: 'image/webp',
  ico: 'image/vnd.microsoft.icon',
  tif: 'image/tiff',
  tiff: 'image/tiff',
  psd: 'image/vnd.adobe.photoshop',
  ai: 'application/postscript',
  sketch: 'application/sketch',

  // video
  mp4: 'video/mp4',
  webm: 'video/webm',
  ogv: 'video/ogg',
  avi: 'video/x-msvideo',
  mpeg: 'video/mpeg',
  '3gp': 'video/3gpp',
  '3g2': 'video/3gpp2',

  // audio
  mp3: 'audio/mpeg',
  wav: 'audio/wav',
  weba: 'audio/webm',
  oga: 'audio/ogg',
  opus: 'audio/opus',
  midi: 'audio/midi',
  aac: 'audio/aac',

  // document
  pdf: 'application/pdf',
  doc: 'application/msword',
  docx: 'application/vnd.openxmlformats-officedocument.wordprocessingml.document',
  xls: 'application/vnd.ms-excel',
  xlsx: 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet',
  ppt: 'application/vnd.ms-powerpoint',
  pptx: 'application/vnd.openxmlformats-officedocument.presentationml.presentation',
  txt: 'text/plain',
  csv: 'text/csv',
  rtf: 'application/rtf',
  odt: 'application/vnd.oasis.opendocument.text',

  // archive
  zip: 'application/zip',
  rar: 'application/vnd.rar',
  '7z': 'application/x-7z-compressed',
  tar: 'application/x-tar',
  gz: 'application/gzip',
  bz2: 'application/x-bzip2',

  // executable
  exe: 'application/x-msdownload',
  sh: 'application/x-sh',
  bat: 'application/x-msdos-program',
  apk: 'application/vnd.android.package-archive',
  ipa: 'application/octet-stream',
  jar: 'application/java-archive',
  app: 'application/x-macos-app',
  deb: 'application/x-deb',
  rpm: 'application/x-rpm',

  // code
  js: 'text/javascript',
  ts: 'text/typescript',
  py: 'text/x-python',
  java: 'text/x-java-source',
  cpp: 'text/x-c',
  c: 'text/x-c',
  kt: 'text/x-kotlin',
  rs: 'text/x-rust',
  swift: 'text/x-swift',
  go: 'text/x-go',
  php: 'text/x-php',
  rb: 'text/x-ruby',

  // database
  sqlite: 'application/x-sqlite3',
  db: 'application/x-database',
  sql: 'application/sql',

  // 3d-model
  stl: 'model/stl',
  obj: 'model/obj',
  fbx: 'model/fbx',
  blend: 'model/blender',

  // disk-image
  iso: 'application/x-iso9660-image',
  img: 'application/octet-stream',

  // config
  ini: 'text/plain',
  log: 'text/plain',
  cfg: 'text/plain',

  // font
  ttf: 'font/ttf',
  woff: 'font/woff',
  woff2: 'font/woff2',
  otf: 'font/otf',
};

const categoryMap = new Map<string, FileCategory>([
  ['image/', 'image'],
  ['video/', 'video'],
  ['audio/', 'audio'],
  ['application/pdf', 'document'],
  ['application/msword', 'document'],
  ['application/vnd.openxmlformats-officedocument', 'document'],
  ['application/vnd.ms-powerpoint', 'document'],
  ['application/vnd.oasis.opendocument', 'document'],
  ['application/vnd.ms-excel', 'document'],
  ['text/plain', 'document'],
  ['text/csv', 'document'],
  ['application/rtf', 'document'],
  ['application/zip', 'archive'],
  ['application/vnd.rar', 'archive'],
  ['application/x-7z-compressed', 'archive'],
  ['application/x-tar', 'archive'],
  ['application/gzip', 'archive'],
  ['application/x-bzip2', 'archive'],
  ['application/x-msdownload', 'executable'],
  ['application/vnd.android.package-archive', 'executable'],
  ['application/octet-stream', 'executable'],
  ['application/java-archive', 'executable'],
  ['application/x-deb', 'executable'],
  ['application/x-rpm', 'executable'],
  ['text/javascript', 'code'],
  ['text/typescript', 'code'],
  ['text/x-python', 'code'],
  ['text/x-java-source', 'code'],
  ['text/x-c', 'code'],
  ['text/x-kotlin', 'code'],
  ['text/x-rust', 'code'],
  ['text/x-swift', 'code'],
  ['text/x-go', 'code'],
  ['text/x-php', 'code'],
  ['text/x-ruby', 'code'],
  ['application/x-sqlite3', 'database'],
  ['application/x-database', 'database'],
  ['application/sql', 'database'],
  ['model/', '3d-model'],
  ['application/x-iso9660-image', 'disk-image'],
  ['text/plain', 'config'],
  ['font/', 'font'],
]);

export const getFileType = (url: string): FileTypeResult => {
  const extensionMatch = url.match(/\.([0-9a-z]+)(?:[?#]|$)/i);
  if (!extensionMatch) return { mimeType: 'unknown', category: 'file' };

  const extension = extensionMatch[1].toLowerCase();
  const mimeType = mimeTypeMap[extension] ?? 'application/octet-stream';

  const category =
    categoryMap.get(mimeType) ||
    [...categoryMap.entries()].find(([prefix]) => mimeType.startsWith(prefix))?.[1] ||
    'file';

  return { mimeType, category };
};
