/*
Please consider that the JS part isn't production ready at all, I just code it to show the concept of merging filters and titles together !
*/
$(document).ready(function () {
    $('.filterable .btn-filter').click(function () {
        var $panel = $(this).parents('.filterable'),
            $filters = $panel.find('.filters input'),
            $tbody = $panel.find('.table tbody');
        if ($filters.prop('disabled') == true) {
            $filters.prop('disabled', false);
            $filters.first().focus();
        } else {
            $filters.val('').prop('disabled', true);
            $tbody.find('.no-result').remove();
            $tbody.find('tr').show();
        }
    });

    $('.filterable .filters input').keyup(function (e) {
        /* Ignore tab key */
        var code = e.keyCode || e.which;
        if (code == '9') return;
        /* Useful DOM data and selectors */
        var $input = $(this),
            inputContent = $input.val().toLowerCase(),
            $panel = $input.parents('.filterable'),
            column = $panel.find('.filters th').index($input.parents('th')),
            $table = $panel.find('.table'),
            $rows = $table.find('tbody tr');
        /* Dirtiest filter function ever ;) */
        var $filteredRows = $rows.filter(function () {
            var value = $(this).find('td').eq(column).text().toLowerCase();
            return value.indexOf(inputContent) === -1;
        });
        /* Clean previous no-result if exist */
        $table.find('tbody .no-result').remove();
        /* Show all rows, hide filtered ones (never do that outside of a demo ! xD) */
        $rows.show();
        $filteredRows.hide();
        /* Prepend no-result row if all rows are filtered */
        if ($filteredRows.length === $rows.length) {
            $table.find('tbody').prepend($('<tr class="no-result text-center"><td colspan="' + $table.find('.filters th').length + '">No result found</td></tr>'));
        }
    });
});
var id_item = 0;
var name_item = "";
let input_show_name = document.getElementById("input_show_name");
let input_show_type = document.getElementById("select-item1");
var link_customer = "";
var delete_button_customer = document.getElementById("delete-customer");
var edit_button_customer = document.getElementById("submit-show-customer");

// show Item
function showItem(id, name, value) {
    id_item = id;
    name_item = name;
    console.log(name_item, id_item);

    input_show_name.value = name_item;
    input_show_type.value = value;

}

//End Show Item
// Start function xử lí delete
function deleteCustomer(id) {
    link_customer = "http://localhost:8080" + id;
    delete_button_customer.href = link_customer;
    alert(delete_button_customer.href);

}


window.onload = function () {

    delete_button_customer.onclick = function () {

        return false;
    };

};

// END function xử lí delete

// Show Customer
function showCustomer(id_cus, name, email, birthday, idCard, phone, address, typeService) {
    var id_customer = document.getElementById("show_id_customer");
    var name_customer = document.getElementById("show_name_customer");
    ;
    var email_customer = document.getElementById("show_email_customer");
    ;
    var birthday_customer = document.getElementById("show_birthday_customer");
    ;
    var id_card_customer = document.getElementById("show_idcard_customer");
    ;
    var phone_customer = document.getElementById("show_phone_customer");
    ;
    var address_customer = document.getElementById("show_address-customer");
    ;
    var type_customer = document.getElementById("show_type_customer");
    ;

    id_customer.innerText = id_cus;
    name_customer.value = name;
    email_customer.value = email;
    birthday_customer.value = birthday;
    id_card_customer.value = idCard;
    phone_customer.value = phone;
    address_customer.value = address;
    type_customer.value = "" + typeService;

    console.log(type_customer.value);
    name_customer.disabled = true;
    email_customer.disabled = true;
    birthday_customer.disabled = true;
    id_card_customer.disabled = true;
    phone_customer.disabled = true;
    address_customer.disabled = true;
    type_customer.disabled = true;
    document.getElementById("submit-show-customer").disabled = true;
}

function editCustomer(id_cus, name, email, birthday, idCard, phone, address, typeService) {
    var id_customer = document.getElementById("show_id_customer");
    var name_customer = document.getElementById("show_name_customer");
    ;
    var email_customer = document.getElementById("show_email_customer");
    ;
    var birthday_customer = document.getElementById("show_birthday_customer");
    ;
    var id_card_customer = document.getElementById("show_idcard_customer");
    ;
    var phone_customer = document.getElementById("show_phone_customer");
    ;
    var address_customer = document.getElementById("show_address-customer");
    ;
    var type_customer = document.getElementById("show_type_customer");
    ;

    id_customer.innerText = id_cus;
    name_customer.value = name;
    email_customer.value = email;
    birthday_customer.value = birthday;
    id_card_customer.value = idCard;
    phone_customer.value = phone;
    address_customer.value = address;
    type_customer.value = "" + typeService;
    name_customer.disabled = false;
    email_customer.disabled = false;
    birthday_customer.disabled = false;
    id_card_customer.disabled = false;
    phone_customer.disabled = false;
    address_customer.disabled = false;
    type_customer.disabled = false;
    document.getElementById("submit-show-customer").disabled = false;
    birthday_customer.value = formatDate(birthday);
    // console.log(birthday);
    console.log(birthday_customer.value);

}

function formatDate(date) {
    var d = new Date(date),
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();

    if (month.length < 2)
        month = '0' + month;
    if (day.length < 2)
        day = '0' + day;

    return [year, month, day].join('-');
}

