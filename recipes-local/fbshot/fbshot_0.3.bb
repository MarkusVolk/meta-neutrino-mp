HOMEPAGE = "http://www.sfires.net/fbshot/index.html"
SECTION = "base"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=ea5bed2f60d357618ca161ad539f7c0a"
DEPENDS = " \
           libpng \
           zlib \
"

PR = "r5.1"


SRC_URI = " \
	http://www.sfires.net/stuff/fbshot/fbshot-0.3.tar.gz \
        file://oe-makefile-fix.patch \
        file://fbshot-0.3-32bit_cs_fb.diff \
        file://fbshot-0.3-32bit_td_fb.diff \
	file://fbshot-0.3-libpng16.diff \
"

SRC_URI[md5sum] = "2cc6cc25cdc4cd447a8b0a9662907635"
SRC_URI[sha256sum] = "4cceeed1f9ddfeeffe5e4027fad696ea732af4dd90c28b2cfe9a3bb31787903b"



inherit autotools 


do_compile() {
	 oe_runmake  'PLATTFORM=${@d.getVar('MACHINE',1).upper()}'
}

do_install () {
	install -D -m 0755 ${S}/fbshot ${D}${bindir}/fbshot
}


#FILES_${PN}-dbg += "/bin/fbshot/.debug"
