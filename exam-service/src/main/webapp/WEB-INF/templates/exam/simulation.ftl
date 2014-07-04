<@master template="layout/master">
<div class="row full page-title">
    <form class="custom" id="simulateForm" action="<@url value='/exam/simulation'/>" method="post">

        <div class="row collapse">
            <div class="large-3 left columns">
                <div class="small-7 columns text-right">
                    <h4>Select Condition:</h4>
                </div>
                <div class="small-4 columns">
                    <div id="errInfo" class="errorBox"></div>
                </div>

            </div>
            <div class="large-2 left columns">
                <div class="small-4 columns text-right">
                    <label style="margin-top:10px;">Type:</label>
                </div>
                <div class="small-7 columns">
                    <select id="type" name="type">
                        <#if types??>
                            <#list types as type>
                                <option value=${type}>${type}</option>
                            </#list>
                        </#if>
                    </select>
                </div>
            </div>

            <div class="large-2 left columns">
                <div class="small-4 columns text-right">
                    <label style="margin-top:10px;">Level:</label>
                </div>
                <div class="small-7 columns">
                    <select id="level" name="level">
                        <#if levels??>
                            <#list levels as level>
                                <option value=${level}>${level}</option>
                            </#list>
                        </#if>
                    </select>
                </div>
            </div>

            <div class="large-2 left columns">
                <div class="small-4 columns text-right">
                    <label style="margin-top:10px;">Section:</label>
                </div>
                <div class="small-7 columns">
                    <select id="section" name="section">
                        <#if sections??>
                            <#list sections as section>
                                <option value=${section}>${section}</option>
                            </#list>
                        </#if>
                    </select>
                </div>
            </div>

            <div class="large-3 left columns" style="padding-left: 55px;">
                <div class="small-3 columns">
                    <a class="small radius button" id="button" onclick="simulate()" href="javascript:void(0)">Simulate</a>
                </div>
                <div class="loadingDiv displayNone" id="loadingLogo"></div>
            </div>
        </div>

    </form>
</div>

<div class="row">
    <fieldset>
        <div id="selects"></div>
        <div id="blanks"></div>
        <div id="calculates"></div>
        <div id="shortAnswers"></div>
    </fieldset>
</div>

<script type="text/javascript">
    function simulate() {
        $("#errorInfo").text('');
        $("#selects").text('');
        $("#blanks").text('');
        $("#calculates").text('');
        $("#shortAnswers").text('');

        $("#loadingLogo").css("display", "inline-block");
        $("#button").attr('disabled', true);
        $("#simulateForm").ajaxSubmit({callback: function (result) {
            $('#loadingLogo').css("display", "none");
            $("#button").attr("disabled", false);
            var selects = result.Select;
            var blanks = result.Blank;
            var calculates = result.Calculate;
            var shortAnswers = result.ShortAnswer;
            if (selects.length > 0) {
                var inputValue = "<div>Select</div><br/><br/>";
                for (var i = 1; i <= selects.length; i++) {
                    inputValue += "<div>" + i + ")." + selects[i - 1].name + "</div><br/>";
                }
                $(inputValue).appendTo($("#selects"));
            }

            if (blanks.length > 0) {
                var inputValue = "<div>Blank</div><br/><br/>";
                for (var i = 1; i <= blanks.length; i++) {
                    inputValue += "<div>" + i + ")." + blanks[i - 1].name + "</div><br/>";
                }
                $(inputValue).appendTo($("#blanks"));
            }

            if (calculates.length > 0) {
                var inputValue = "<div>Calculate</div><br/><br/>";
                for (var i = 1; i <= calculates.length; i++) {
                    inputValue += "<div>" + i + ")." + calculates[i - 1].name + "</div><br/>";
                }
                $(inputValue).appendTo($("#calculates"));
            }

            if (shortAnswers.length > 0) {
                var inputValue = "<div>Short Answer</div><br/><br/>";
                for (var i = 1; i <= shortAnswers.length; i++) {
                    inputValue += "<div>" + i + ")." + shortAnswers[i - 1].name + "</div><br/>";
                }
                $(inputValue).appendTo($("#shortAnswers"));
            }
        }, validate: false});
    }
</script>
</@master>