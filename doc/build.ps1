$ErrorActionPreference = "Stop"
pushd $PSScriptRoot

# Ensure 0install is in PATH
if (!(Get-Command 0install -ErrorAction SilentlyContinue)) {
    echo "Downloading 0install"
    mkdir -Force "$env:TEMP\zero-install" | Out-Null
    Invoke-WebRequest "https://get.0install.net/0install.exe" -OutFile "$env:TEMP\zero-install\0install.exe"
    $env:PATH = "$env:TEMP\zero-install;$env:PATH"
}

if (Test-Path ..\target\docs) {rm -Recurse -Force ..\target\docs}
mkdir ..\target\docs | Out-Null

0install run --batch http://repo.roscidus.com/devel/doxygen

popd
