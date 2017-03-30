$(function () {

    function getSearchConditions() {
        var searchConditions = {};

        searchConditions.pageIndex = 0;
        searchConditions.searchTerm = $("#searchTerm").text();

        return searchConditions;
    }

    function findPersonCount(callback) {
        $.ajax({
            type: "POST",
            url: "/user/count",
            data: JSON.stringify(searchConditions),
            contentType: "application/json",
            success: function(results) {
                $("#user-count").html(results);

                callback(parseInt(results, 10));
            }
        });
    };

    var handlePaginationClick = function(new_page_index, pagination_container) {
        searchConditions.pageIndex = new_page_index;

        var resultHolder = $("#user-list-holder");

        var source = $("#template-user-list").html();
        var template = Handlebars.compile(source);

        var userSearchUrl = "/user/search/page";

        $.ajax({
            type: "POST",
            url: userSearchUrl,
            data: JSON.stringify(searchConditions),
            contentType: "application/json",
            success: function(results) {
                resultHolder.html(template({users: results}));

                //Removes the pagination elements if no results is found
                if (results.length === 0) {
                    $(".pagination-holder").addClass("hidden");
                }
                else {
                    $(".pagination-holder").removeClass("hidden");
                }
            }
        });
    };

    var initPaginator = function (userCount) {
        $(".pagination-holder").pagination(userCount, {
            current_page: searchConditions.page,
            items_per_page:5,
            load_first_page: true,
            next_show_always: false,
            callback: handlePaginationClick,
            prev_show_always: false
        });
    };

    var searchConditions = getSearchConditions();
    findPersonCount(initPaginator);
});

