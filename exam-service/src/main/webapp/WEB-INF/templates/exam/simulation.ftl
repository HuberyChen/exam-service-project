<@master template="layout/master">
<div class="row full page-title">
    <form class="custom" id="showDetailForm" action="<@url value='/interface/detail'/>" method="post">
        <input id="offset" name="offset" type="hidden" value="0"/>

        <div class="row collapse">
            <div class="large-3 left columns">
                <div class="small-7 columns text-right">
                    <h4>Select Condition:</h4>
                </div>
                <div class="small-4 columns">
                    <div id="errInfo" class="errorBox"></div>
                </div>

            </div>
            <div class="large-3 left columns">
                <div class="small-4 columns text-right">
                    <label style="margin-top:10px;">Project:</label>
                </div>
                <div class="small-7 columns">
                    <select id="projectList" name="project">
                        <#if projects??>
                            <#list projects as project>
                                <option value=${project.name}>${project.name}</option>
                            </#list>
                        </#if>
                    </select>
                </div>
            </div>
            <div class="large-2 left columns">
                <div class="small-4 columns text-right"><label style="margin-top:10px;">*Start date:</label></div>
                <div class="small-7 columns"><input class="date left hasDatePicker required date" type="date" id="startDate" name="startDate"/></div>
            </div>
            <div class="large-2 left columns">
                <div class="small-4 columns text-right"><label style="margin-top:10px;">*End date:</label></div>
                <div class="small-7 columns"><input class="date left hasDatePicker required date" type="date" id="endDate" name="endDate"/></div>
            </div>
            <div class="large-2 left columns" style="padding-left: 55px;">
                <div class="small-3 columns">
                    <a class="small radius button" id="button" onclick="interfaceDetailShow()" href="javascript:void(0)">Search</a>
                </div>
                <div class="loadingDiv displayNone" id="loadingLogo"></div>
            </div>
        </div>

    </form>
</div>
</@master>