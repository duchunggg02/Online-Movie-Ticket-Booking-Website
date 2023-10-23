function deleteApi(path) {
    if (confirm("Xóa?") === true) {
        fetch(path, {
            method: "delete"
        }).then(res => {
            if (res.status === 204)
                location.reload();
            else
                alert("Error");
        });
    }
}
